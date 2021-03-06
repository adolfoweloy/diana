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

package org.jnosql.diana.api.column;


import org.jnosql.diana.api.Condition;

import java.util.Objects;

/**
 * The default implementation of {@link ColumnCondition}
 */
class DefaultColumnCondition implements ColumnCondition {

    private final Column column;

    private final Condition condition;

    private DefaultColumnCondition(Column column, Condition condition) {
        this.column = column;
        this.condition = condition;
    }

    public static DefaultColumnCondition of(Column column, Condition condition) {
        return new DefaultColumnCondition(Objects.requireNonNull(column,"Column is required") , condition);
    }

    public Column getColumn() {
        return column;
    }

    public Condition getCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DefaultColumnCondition that = (DefaultColumnCondition) o;
        return Objects.equals(column, that.column) &&
                condition == that.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, condition);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DefaultColumnCondition{");
        sb.append("column=").append(column);
        sb.append(", condition=").append(condition);
        sb.append('}');
        return sb.toString();
    }
}
