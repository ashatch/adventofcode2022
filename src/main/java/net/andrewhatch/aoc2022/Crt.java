package net.andrewhatch.aoc2022;

import java.util.Arrays;

public class Crt {
  char[] display = new char[240];
  char[] sprite = new char[40];

  public Crt() {
    Arrays.fill(display, ' ');
    Arrays.fill(sprite, '.');
  }

  public String toString() {
    return spriteString() + "\n" + displayString() + "\n---\n";
  }

  private String spriteString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < sprite.length; i++) {
      sb.append(sprite[i]);
    }
    sb.append("\n");
    return sb.toString();
  }

  public String displayString() {
    StringBuilder sb = new StringBuilder();
    int count = 1;
    for (int i = 0; i < display.length; i++) {
      if (count == 41) {
        count = 1;
        sb.append('\n');
      }
      sb.append(display[i]);
      count++;
    }
    sb.append('\n');
    return sb.toString();
  }

  public void setSpritePosition(int pos) {
    pos = pos % 40;
    for (int i = 0; i < sprite.length; i++) {
      if (i == pos) {
        sprite[i] = '#';
      } else if (i == pos - 1) {
        sprite[i] = '#';
      } else if (i == pos + 1) {
        sprite[i] = '#';
      } else {
        sprite[i] = '.';
      }
    }
  }

  public void drawSpriteAtPos(int pos) {
    if (pos >= display.length) {
      return;
    }
    int spritePos = (pos % 40) - 1;
    if (spritePos < 0) spritePos = 0;
    char spriteChar = sprite[spritePos];
    this.display[pos - 1] = spriteChar;
  }

  public static void main(String[] args) {
    Crt crt = new Crt();
    System.out.println(crt);
  }
}
