package ch.weiss.bitset;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import ch.rweiss.bitset.IntBitSet;

public class TestIntBitSet
{
  @Test
  public void equals()
  {
    assertThat(IntBitSet.EMPTY).isNotEqualTo(null);
    assertThat(IntBitSet.EMPTY).isNotEqualTo("Hi");
    assertThat(IntBitSet.EMPTY).isEqualTo(IntBitSet.EMPTY);
    assertThat(IntBitSet.EMPTY).isEqualTo(IntBitSet.fromInt(0));
    assertThat(IntBitSet.fromInt(0xF051)).isEqualTo(IntBitSet.fromInt(0xF051));
    assertThat(IntBitSet.fromInt(0xF051)).isNotEqualTo(IntBitSet.fromInt(0xF050));
  }
  
  @Test
  public void hashCodeTest()
  {
    assertThat(IntBitSet.EMPTY.hashCode()).isEqualTo(IntBitSet.fromInt(0).hashCode());
    assertThat(IntBitSet.EMPTY.hashCode()).isNotEqualTo(IntBitSet.fromInt(0xF051).hashCode());
  }
  
  @Test
  public void toInt()
  {
    assertThat(IntBitSet.EMPTY.toInt()).isEqualTo(0);
    assertThat(IntBitSet.fromInt(0xF051).toInt()).isEqualTo(0xF051);
  }
  
  @Test
  public void add()
  {
    IntBitSet testee = IntBitSet.fromInt(0xF051);
    assertThat(IntBitSet.EMPTY.add(testee)).isEqualTo(testee);
    assertThat(testee.add(testee)).isEqualTo(testee);
    assertThat(testee.add(IntBitSet.fromInt(0x0380))).isEqualTo(IntBitSet.fromInt(0xF3D1)); 
  }

  @Test
  public void remove()
  {
    IntBitSet testee = IntBitSet.fromInt(0xF051);
    assertThat(IntBitSet.EMPTY.remove(testee)).isEqualTo(IntBitSet.EMPTY);
    assertThat(testee.remove(testee)).isEqualTo(IntBitSet.EMPTY);
    assertThat(testee.remove(IntBitSet.fromInt(0x3010))).isEqualTo(IntBitSet.fromInt(0xC041));
  }
  
  @Test
  public void contains()
  {
    IntBitSet testee = IntBitSet.fromInt(0xF051);
    assertThat(IntBitSet.EMPTY.contains(IntBitSet.EMPTY)).isTrue();
    assertThat(testee.contains(IntBitSet.fromInt(0x8001))).isTrue();
    assertThat(testee.contains(IntBitSet.fromInt(0x8003))).isFalse();
    assertThat(testee.contains(IntBitSet.fromInt(0x0001))).isTrue();
    assertThat(testee.contains(IntBitSet.fromInt(0x0003))).isFalse();
    assertThat(testee.contains(IntBitSet.fromInt(0x0002))).isFalse();
  }
  
  @Test
  public void containsOneOf()
  {
    IntBitSet testee = IntBitSet.fromInt(0xF051);
    assertThat(IntBitSet.EMPTY.containsOneOf(IntBitSet.EMPTY)).isFalse();
    assertThat(testee.containsOneOf(IntBitSet.fromInt(0x8001))).isTrue();
    assertThat(testee.containsOneOf(IntBitSet.fromInt(0x8003))).isTrue();
    assertThat(testee.containsOneOf(IntBitSet.fromInt(0x0001))).isTrue();
    assertThat(testee.containsOneOf(IntBitSet.fromInt(0x0003))).isTrue();
    assertThat(testee.containsOneOf(IntBitSet.fromInt(0x0002))).isFalse();
  }
  
  @Test
  public void doesNotContain()
  {
    IntBitSet testee = IntBitSet.fromInt(0xF051);
    assertThat(IntBitSet.EMPTY.doesNotContain(IntBitSet.EMPTY)).isTrue();
    assertThat(testee.doesNotContain(IntBitSet.fromInt(0x8001))).isFalse();
    assertThat(testee.doesNotContain(IntBitSet.fromInt(0x8003))).isFalse();
    assertThat(testee.doesNotContain(IntBitSet.fromInt(0x0001))).isFalse();
    assertThat(testee.doesNotContain(IntBitSet.fromInt(0x0003))).isFalse();
    assertThat(testee.doesNotContain(IntBitSet.fromInt(0x0402))).isTrue();
  }

  @Test
  public void doesNotContainOneOf()
  {
    IntBitSet testee = IntBitSet.fromInt(0xF051);
    assertThat(IntBitSet.EMPTY.doesNotContainOneOf(IntBitSet.EMPTY)).isFalse();
    assertThat(testee.doesNotContainOneOf(IntBitSet.fromInt(0x8001))).isFalse();
    assertThat(testee.doesNotContainOneOf(IntBitSet.fromInt(0x8003))).isTrue();
    assertThat(testee.doesNotContainOneOf(IntBitSet.fromInt(0x0001))).isFalse();
    assertThat(testee.doesNotContainOneOf(IntBitSet.fromInt(0x0003))).isTrue();
    assertThat(testee.doesNotContainOneOf(IntBitSet.fromInt(0x0402))).isTrue();
  }
  
  @Test
  public void toStringTest()
  { 
    IntBitSet testee = IntBitSet.fromInt(0xF051);
    assertThat(IntBitSet.EMPTY.toString()).isEqualTo("00000000000000000000000000000000");
    assertThat(testee.toString()).isEqualTo("00000000000000001111000001010001");
  }
}
