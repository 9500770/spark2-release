/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.sources.v2.reader;

import java.io.Closeable;

import org.apache.spark.annotation.InterfaceStability;

/**
 * A data reader returned by {@link ReadTask#createDataReader()} and is responsible for
 * outputting data for a RDD partition.
 *
 * Note that, Currently the type `T` can only be {@link org.apache.spark.sql.Row} for normal data
 * source readers, or {@link org.apache.spark.sql.catalyst.expressions.UnsafeRow} for data source
 * readers that mix in {@link SupportsScanUnsafeRow}.
 */
@InterfaceStability.Evolving
public interface DataReader<T> extends Closeable {

  /**
   * Proceed to next record, returns false if there is no more records.
   */
  boolean next();

  /**
   * Return the current record. This method should return same value until `next` is called.
   */
  T get();
}
