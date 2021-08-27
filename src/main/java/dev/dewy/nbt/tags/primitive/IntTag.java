package dev.dewy.nbt.tags.primitive;

import dev.dewy.nbt.TagType;
import dev.dewy.nbt.TagTypeRegistry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * The int tag (type ID 3) is used for storing a 32-bit signed two's complement integer; a Java primitive {@code int}.
 *
 * @author dewy
 */
@NoArgsConstructor
@AllArgsConstructor
public class IntTag extends NumericalTag<Integer> {
    private int value;

    /**
     * Constructs an int tag with a given name and value.
     *
     * @param name the tag's name.
     * @param value the tag's {@code int} value.
     */
    public IntTag(String name, int value) {
        this.setName(name);
        this.setValue(value);
    }

    @Override
    public byte getTypeId() {
        return TagType.INT.getId();
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    /**
     * Sets the {@code int} value of this int tag.
     *
     * @param value new {@code int} value to be set.
     */
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void write(DataOutput output, int depth, TagTypeRegistry registry) throws IOException {
        output.writeInt(this.value);
    }

    @Override
    public IntTag read(DataInput input, int depth, TagTypeRegistry registry) throws IOException {
        this.value = input.readInt();

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntTag intTag = (IntTag) o;

        return value == intTag.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}