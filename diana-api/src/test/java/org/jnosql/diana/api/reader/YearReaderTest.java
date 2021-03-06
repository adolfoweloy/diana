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

import java.time.Year;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Marcelo de Souza
 */
public class YearReaderTest {

    private ReaderField readerField;

    @Before
    public void init() {
        readerField = new YearReader();
    }

    @Test
    public void shouldValidateCompatibility() {
        assertTrue(readerField.isCompatible(Year.class));
        assertFalse(readerField.isCompatible(String.class));
        assertFalse(readerField.isCompatible(Long.class));
    }

    @Test
    public void shouldConvert() {
        Year year = Year.parse("2009");

        assertEquals(year, readerField.read(Year.class, Year.parse("2009")));
        assertEquals(year, readerField.read(String.class, "2009"));
        assertEquals(year, readerField.read(Integer.class, 2009));
        assertEquals(year, readerField.read(Long.class, 2009));
    }


}
