/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jnosql.diana.api.reader;

import org.jnosql.diana.api.ReaderField;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;


public class StringReaderTest {

    private ReaderField readerField;

    @Before
    public void init() {
        readerField = new StringReader();
    }

    @Test
    public void shouldValidateCompatibility() {
        assertTrue(readerField.isCompatible(String.class));
        assertTrue(readerField.isCompatible(CharSequence.class));
        assertFalse(readerField.isCompatible(AtomicBoolean.class));
    }

    @Test
    public void shouldConvert() {
        StringBuilder stringBuilder = new StringBuilder("sb");

        assertEquals(stringBuilder, readerField.read(CharSequence.class, stringBuilder));
        assertEquals(stringBuilder.toString(), readerField.read(String.class, stringBuilder));

        assertEquals("10", readerField.read(CharSequence.class, 10));
        assertEquals("10.0", readerField.read(String.class, 10.00));
        assertEquals("10", readerField.read(CharSequence.class, "10"));
        assertEquals("10", readerField.read(String.class, "10"));
    }


}
