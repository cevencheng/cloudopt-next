/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.cloudopt.next.web.test.plugin

import net.cloudopt.next.logging.Logger
import net.cloudopt.next.web.Plugin


/*
 * @author: Cloudopt
 * @Time: 2018/1/17
 * @Description: Test Case
 */
class TestPlugin : Plugin {

    val logger = Logger.getLogger(this::class.java.simpleName)

    override fun start(): Boolean {
        logger.info("TestPlugin is starting!")
        return true
    }

    override fun stop(): Boolean {
        logger.info("TestPlugin is stopping!")
        return true
    }

}
    