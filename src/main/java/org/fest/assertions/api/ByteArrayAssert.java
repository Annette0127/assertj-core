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

import org.fest.assertions.core.EnumerableAssert;
import org.fest.assertions.data.Index;
import org.fest.assertions.internal.ByteArrays;
import org.fest.util.VisibleForTesting;

/**
 * Assertion methods for arrays of {@code byte}s. To create an instance of this class, use the factory method
 * <code>{@link Assertions#assertThat(byte[])}</code>.
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class ByteArrayAssert extends GenericAssert<ByteArrayAssert, byte[]> implements EnumerableAssert<ByteArrayAssert> {

  @VisibleForTesting ByteArrays arrays = ByteArrays.instance();

  protected ByteArrayAssert(byte[] actual) {
    super(actual, ByteArrayAssert.class);
  }

  /** {@inheritDoc} */
  public void isNullOrEmpty() {
    arrays.assertNullOrEmpty(info, actual);
  }

  /** {@inheritDoc} */
  public void isEmpty() {
    arrays.assertEmpty(info, actual);
  }

  /** {@inheritDoc} */
  public ByteArrayAssert isNotEmpty() {
    arrays.assertNotEmpty(info, actual);
    return this;
  }

  /** {@inheritDoc} */
  public ByteArrayAssert hasSize(int expected) {
    arrays.assertHasSize(info, actual, expected);
    return this;
  }

  /**
   * Verifies that the actual array contains the given values, in any order.
   * @param values the given values.
   * @return {@code this} assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array does not contain the given values.
   */
  public ByteArrayAssert contains(byte... values) {
    arrays.assertContains(info, actual, values);
    return this;
  }

  /**
   * Verifies that the actual array contains only the given values and nothing else, in any order.
   * @param values the given values.
   * @return {@code this} assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array does not contain the given values, i.e. the actual array contains some
   * or none of the given values, or the actual array contains more values than the given ones.
   */
  public ByteArrayAssert containsOnly(byte... values) {
    arrays.assertContainsOnly(info, actual, values);
    return this;
  }

  /**
   * Verifies that the actual array contains the given sequence, without any other values between them.
   * @param sequence the sequence of objects to look for.
   * @return this assertion object.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the given array is {@code null}.
   * @throws AssertionError if the actual array does not contain the given sequence.
   */
  public ByteArrayAssert containsSequence(byte... sequence) {
    arrays.assertContainsSequence(info, actual, sequence);
    return this;
  }

  /**
   * Verifies that the actual array contains the given value at the given index.
   * @param value the value to look for.
   * @param index the index where the value should be stored in the actual array.
   * @return this assertion object.
   * @throws AssertionError if the actual array is {@code null} or empty.
   * @throws NullPointerException if the given {@code Index} is {@code null}.
   * @throws IndexOutOfBoundsException if the value of the given {@code Index} is equal to or greater than the size of
   * the actual array.
   * @throws AssertionError if the actual array does not contain the given value at the given index.
   */
  public ByteArrayAssert contains(byte value, Index index) {
    arrays.assertContains(info, actual, value, index);
    return this;
  }

  /**
   * Verifies that the actual array does not contain the given values.
   * @param values the given values.
   * @return {@code this} assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array contains the given values.
   */
  public ByteArrayAssert doesNotContain(byte... values) {
    arrays.assertDoesNotContain(info, actual, values);
    return this;
  }

  /**
   * Verifies that the actual array does not contain the given value at the given index.
   * @param value the value to look for.
   * @param index the index where the value should be stored in the actual array.
   * @return this assertion object.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws NullPointerException if the given {@code Index} is {@code null}.
   * @throws AssertionError if the actual array contains the given value at the given index.
   */
  public ByteArrayAssert doesNotContain(byte value, Index index) {
    arrays.assertDoesNotContain(info, actual, value, index);
    return this;
  }

  /**
   * Verifies that the actual array does not contain duplicates.
   * @return {@code this} assertion object.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array contains duplicates.
   */
  public ByteArrayAssert doesNotHaveDuplicates() {
    arrays.assertDoesNotHaveDuplicates(info, actual);
    return this;
  }

  /**
   * Verifies that the actual array starts with the given sequence of objects, without any other objects between them.
   * Similar to <code>{@link #containsSequence(byte...)}</code>, but it also verifies that the first element in the
   * sequence is also first element of the actual array.
   * @param sequence the sequence of objects to look for.
   * @return this assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array does not start with the given sequence.
   */
  public ByteArrayAssert startsWith(byte... sequence) {
    arrays.assertStartsWith(info, actual, sequence);
    return this;
  }

  /**
   * Verifies that the actual array ends with the given sequence of objects, without any other objects between them.
   * Similar to <code>{@link #containsSequence(byte...)}</code>, but it also verifies that the last element in the
   * sequence is also last element of the actual array.
   * @param sequence the sequence of objects to look for.
   * @return this assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array does not end with the given sequence.
   */
  public ByteArrayAssert endsWith(byte... sequence) {
    arrays.assertEndsWith(info, actual, sequence);
    return this;
  }
}
