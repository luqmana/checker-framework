/*
 * Copyright (C) 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.common.collect;

import org.checkerframework.checker.nullness.qual.Nullable;
//import javax.annotation.Nullable;
import org.checkerframework.dataflow.qual.Pure;

import java.util.Map;

import com.google.common.annotations.GwtCompatible;

/**
 * A map entry which forwards all its method calls to another map entry.
 * Subclasses should override one or more methods to modify the behavior of the
 * backing map entry as desired per the <a
 * href="http://en.wikipedia.org/wiki/Decorator_pattern">decorator pattern</a>.
 *
 * @see ForwardingObject
 * @author Mike Bostock
 */
@GwtCompatible
    @SuppressWarnings("nullness:generic.argument")
    public abstract class ForwardingMapEntry<K extends /*@Nullable*/ Object, V extends /*@Nullable*/ Object>
    extends ForwardingObject implements Map.Entry<K, V> {

  @Override protected abstract Map.Entry<K, V> delegate();
  @Override
  @Pure public K getKey() {
    return delegate().getKey();
  }

  @Override
  @Pure public V getValue() {
    return delegate().getValue();
  }

  @Override
  public V setValue(V value) {
    return delegate().setValue(value);
  }

  @Pure @Override public boolean equals(@Nullable Object object) {
    return delegate().equals(object);
  }

  @Pure @Override public int hashCode() {
    return delegate().hashCode();
  }
}
