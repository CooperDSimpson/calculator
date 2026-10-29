package core;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BitWise {

    private long value;

    private final int byteSize;
    private final int bitSize;

    private final Map<String, Integer> names = new HashMap<>();
    private final Map<String, Long> masks = new HashMap<>();

    // ==================== CONSTRUCTORS ====================

    public BitWise(long value) {
        this(value, Long.BYTES);
    }

    public BitWise(long value, int byteSize) {
        if (byteSize != 1 && byteSize != 2
                && byteSize != 4 && byteSize != 8) {
            throw new IllegalArgumentException(
                    "Byte size must be 1, 2, 4, or 8"
            );
        }

        this.byteSize = byteSize;
        this.bitSize = byteSize * Byte.SIZE;
        this.value = value & getSizeMask();
    }

    public BitWise(BitWise other) {
        Objects.requireNonNull(other, "Other cannot be null");

        this.byteSize = other.byteSize;
        this.bitSize = other.bitSize;
        this.value = other.value;

        this.names.putAll(other.names);
        this.masks.putAll(other.masks);
    }

    // ==================== SIZE ====================

    private long getSizeMask() {
        return byteSize == Long.BYTES
                ? -1L
                : (1L << bitSize) - 1L;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= bitSize) {
            throw new IndexOutOfBoundsException(
                    "Bit index must be between 0 and "
                    + (bitSize - 1) + ": " + index
            );
        }
    }

    private long constrain(long value) {
        return value & getSizeMask();
    }

    public int getByteSize() {
        return byteSize;
    }

    public int getBitSize() {
        return bitSize;
    }

    // ==================== BASIC ACCESS ====================

    public boolean get(int index) {
        checkIndex(index);
        return ((value >>> index) & 1L) != 0;
    }

    public boolean get(String name) {
        return get(getIndex(name));
    }

    public void set(int index, boolean bit) {
        checkIndex(index);

        if (bit) {
            value |= (1L << index);
        } else {
            value &= ~(1L << index);
        }

        value = constrain(value);
    }

    public void set(String name, boolean bit) {
        set(getIndex(name), bit);
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = constrain(value);
    }

    // ==================== NAMED FLAGS ====================

    public void addName(String name, int index) {
        Objects.requireNonNull(name, "Name cannot be null");
        checkIndex(index);

        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    "Name cannot be blank"
            );
        }

        names.put(name, index);
    }

    public boolean hasName(String name) {
        return names.containsKey(name);
    }

    public int getIndex(String name) {
        Integer index = names.get(name);

        if (index == null) {
            throw new IllegalArgumentException(
                    "Unknown bit name: " + name
            );
        }

        return index;
    }

    public void removeName(String name) {
        names.remove(name);
    }

    public Map<String, Integer> getNames() {
        return Map.copyOf(names);
    }

    // ==================== NAMED MASKS ====================

    public void addMask(String name, long mask) {
        Objects.requireNonNull(name, "Name cannot be null");

        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    "Name cannot be blank"
            );
        }

        masks.put(name, constrain(mask));
    }

    public boolean hasMask(String name) {
        return masks.containsKey(name);
    }

    public long getMask(String name) {
        Long mask = masks.get(name);

        if (mask == null) {
            throw new IllegalArgumentException(
                    "Unknown mask: " + name
            );
        }

        return mask;
    }

    public void setMask(String name, boolean enabled) {
        long mask = getMask(name);

        if (enabled) {
            value |= mask;
        } else {
            value &= ~mask;
        }

        value = constrain(value);
    }

    public boolean isMaskSet(String name) {
        long mask = getMask(name);
        return mask != 0L && (value & mask) == mask;
    }

    public Map<String, Long> getMasks() {
        return Map.copyOf(masks);
    }

    // ==================== TOGGLE / CLEAR ====================

    public void toggle(int index) {
        checkIndex(index);
        value ^= (1L << index);
    }

    public void toggle(String name) {
        toggle(getIndex(name));
    }

    public void clear(int index) {
        set(index, false);
    }

    public void clear(String name) {
        set(name, false);
    }

    public void clearAll() {
        value = 0L;
    }

    public void setAll() {
        value = getSizeMask();
    }

    public void flipAll() {
        value = constrain(~value);
    }

    // ==================== BULK BIT OPERATIONS ====================

    public void setBits(long mask) {
        value = constrain(value | mask);
    }

    public void clearBits(long mask) {
        value = constrain(value & ~mask);
    }

    public void toggleBits(long mask) {
        value = constrain(value ^ mask);
    }

    public boolean any(long mask) {
        return (value & constrain(mask)) != 0L;
    }

    public boolean all(long mask) {
        mask = constrain(mask);
        return mask != 0L && (value & mask) == mask;
    }

    public void and(BitWise other) {
        Objects.requireNonNull(other, "Other cannot be null");
        value = constrain(value & other.value);
    }

    public void or(BitWise other) {
        Objects.requireNonNull(other, "Other cannot be null");
        value = constrain(value | other.value);
    }

    public void xor(BitWise other) {
        Objects.requireNonNull(other, "Other cannot be null");
        value = constrain(value ^ other.value);
    }

    public void not() {
        flipAll();
    }

    // ==================== BIT INFORMATION ====================

    public int count() {
        return Long.bitCount(value);
    }

    public int countZeros() {
        return bitSize - count();
    }

    public int countTrailingZeros() {
        return value == 0L
                ? bitSize
                : Math.min(
                        Long.numberOfTrailingZeros(value),
                        bitSize
                );
    }

    public int firstSetBit() {
        return value == 0L
                ? -1
                : Long.numberOfTrailingZeros(value);
    }

    public boolean any() {
        return value != 0L;
    }

    public boolean none() {
        return value == 0L;
    }

    public boolean all() {
        return value == getSizeMask();
    }

    // ==================== FORMATTING ====================

    public String toBinaryString() {
        String binary = Long.toBinaryString(value);

        return "0".repeat(bitSize - binary.length()) + binary;
    }

    public String toHexString() {
        return String.format(
                "%0" + (byteSize * 2) + "X",
                value
        );
    }

    public String toUnsignedString() {
        return Long.toUnsignedString(value);
    }

    @Override
    public String toString() {
        return toBinaryString();
    }

    // ==================== COPY / COMPARISON ====================

    public BitWise copy() {
        return new BitWise(this);
    }

    public boolean sameValue(BitWise other) {
        return other != null && value == other.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BitWise other)) {
            return false;
        }

        return value == other.value
                && byteSize == other.byteSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, byteSize);
    }
}