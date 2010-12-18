/*
 * Created on Dec 17, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.assertions.api;

import static junit.framework.Assert.assertSame;
import static org.fest.assertions.test.Arrays.arrayOfBytes;
import static org.mockito.Mockito.*;

import org.fest.assertions.internal.ByteArrays;
import org.junit.*;

/**
 * Tests for <code>{@link ByteArrayAssert#containsOnly(byte...)}</code>.
 *
 * @author Alex Ruiz
 */
public class ByteArrayAssert_containsOnly_Test {

  private ByteArrays arrays;
  private ByteArrayAssert assertions;

  @Before public void setUp() {
    arrays = mock(ByteArrays.class);
    assertions = new ByteArrayAssert(new byte[0]);
    assertions.arrays = arrays;
  }

  @Test public void should_verify_that_actual_contains_given_values_only() {
    assertions.containsOnly((byte)6, (byte)8);
    verify(arrays).assertContainsOnly(assertions.info, assertions.actual, arrayOfBytes(6, 8));
  }

  @Test public void should_return_this() {
    ByteArrayAssert returned = assertions.containsOnly((byte)8);
    assertSame(assertions, returned);
  }
}
