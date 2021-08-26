package dev.dewy.nbt.tags.primitive;

import dev.dewy.nbt.TagType;
import dev.dewy.nbt.TagTypeRegistry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@NoArgsConstructor
@AllArgsConstructor
public class LongTag extends NumericalTag<Long> {
    private long value;

    public LongTag(String name, long value) {
        this.setName(name);
        this.setValue(value);
    }

    @Override
    public byte getTypeId() {
        return TagType.LONG.getId();
    }

    @Override
    public Long getValue() {
        return this.value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public void write(DataOutput output, int depth, TagTypeRegistry registry) throws IOException {
        output.writeLong(this.value);
    }

    @Override
    public LongTag read(DataInput input, int depth, TagTypeRegistry registry) throws IOException {
        this.value = input.readLong();

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LongTag longTag = (LongTag) o;

        return value == longTag.value;
    }

    @Override
    public int hashCode() {
        return (int) (value ^ (value >>> 32));
    }
}
