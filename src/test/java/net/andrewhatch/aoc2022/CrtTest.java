package net.andrewhatch.aoc2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrtTest {
  @Test
  void emptyCrtTest() {
    final Crt crt = new Crt();
    assertThat(crt.displayString()).isEqualTo(
        "                                        \n" +
        "                                        \n" +
        "                                        \n" +
        "                                        \n" +
        "                                        \n" +
        "                                        \n");
  }

  @Test
  void emptySpriteTest() {
    final Crt crt = new Crt();
    assertThat(crt.spriteString()).isEqualTo("........................................\n");
  }

  @Test
  void spriteAtOneTest() {
    final Crt crt = new Crt();
    crt.setSpritePosition(1);
    assertThat(crt.spriteString()).isEqualTo("###.....................................\n");
  }

  @Test
  void spriteAtZeroTest() {
    final Crt crt = new Crt();
    crt.setSpritePosition(0);
    assertThat(crt.spriteString()).isEqualTo("##......................................\n");
  }

  @Test
  void spriteAtMinusOneTest() {
    final Crt crt = new Crt();
    crt.setSpritePosition(-1);
    assertThat(crt.spriteString()).isEqualTo("#.......................................\n");
  }

  @Test
  void spriteAtMinusTwoTest() {
    final Crt crt = new Crt();
    crt.setSpritePosition(-2);
    assertThat(crt.spriteString()).isEqualTo("........................................\n");
  }

  @Test
  void spriteAt39Test() {
    final Crt crt = new Crt();
    crt.setSpritePosition(39);
    assertThat(crt.spriteString()).isEqualTo("......................................##\n");
  }

  @Test
  void spriteAt38Test() {
    final Crt crt = new Crt();
    crt.setSpritePosition(38);
    assertThat(crt.spriteString()).isEqualTo(".....................................###\n");
  }

  @Test
  void spriteAt40Test() {
    final Crt crt = new Crt();
    crt.setSpritePosition(40);
    assertThat(crt.spriteString()).isEqualTo(".......................................#\n");
  }

  @Test
  void spriteAt41Test() {
    final Crt crt = new Crt();
    crt.setSpritePosition(41);
    assertThat(crt.spriteString()).isEqualTo("........................................\n");
  }

  @Test
  void spriteAt79Test() {
    final Crt crt = new Crt();
    crt.setSpritePosition(79);
    assertThat(crt.spriteString()).isEqualTo("........................................\n");
  }

  @Test
  void spikeCrtTest() {
    final Crt crt = new Crt();

    assertThat(crt.displayString()).isEqualTo(
        "                                        \n" +
            "                                        \n" +
            "                                        \n" +
            "                                        \n" +
            "                                        \n" +
            "                                        \n");
  }
}