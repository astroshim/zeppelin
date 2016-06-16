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

package org.apache.zeppelin.user;

import java.util.HashMap;
import java.util.Map;

/**
 * User Credentials POJO
 */
public class UserCredentials {
  private Map<String, UsernamePassword> userCredentials;

  public UserCredentials() {
    this.userCredentials = new HashMap<>();
  }

  public UsernamePassword getUsernamePassword(String entity) {
    return userCredentials.get(entity);
  }

  public void putUsernamePassword(String entity, UsernamePassword up) {
    synchronized (userCredentials) {
      userCredentials.put(entity, up);
    }
  }

  public void removeUsernamePassword(String entity) {
    synchronized (userCredentials) {
      userCredentials.remove(entity);
    }
  }

  public boolean existUsernamePassword(String entity) {
    synchronized (userCredentials) {
      return userCredentials.containsKey(entity);
    }
  }

  @Override
  public String toString() {
    return "UserCredentials{" +
        "userCredentials=" + userCredentials +
        '}';
  }
}
