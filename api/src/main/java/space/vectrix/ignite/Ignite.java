/*
 * This file is part of Ignite, licensed under the MIT License (MIT).
 *
 * Copyright (c) vectrix.space <https://vectrix.space/>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package space.vectrix.ignite;

import org.jetbrains.annotations.NotNull;
import space.vectrix.ignite.mod.Mods;

/**
 * Provides static access to the main functions of Ignite.
 *
 * @author vectrix
 * @since 1.0.0
 */
public final class Ignite {
  private static Platform PLATFORM;

  /* package */ static void initialize(final @NotNull Platform platform) {
    Ignite.PLATFORM = platform;
  }

  /**
   * Returns the {@link Mods}.
   *
   * @return the mods
   * @since 1.0.0
   */
  public static @NotNull Mods mods() {
    if(Ignite.PLATFORM == null) throw new IllegalStateException("Ignite has not been initialized yet!");
    return Ignite.PLATFORM.mods();
  }

  private Ignite() {
  }

  static {
    System.out.println(Ignite.class.getClassLoader());
    new Exception().printStackTrace();
  }
}
