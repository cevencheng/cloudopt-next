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
package net.cloudopt.next.kafka

import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.kafka.client.consumer.KafkaConsumer
import io.vertx.kafka.client.producer.KafkaProducer
import io.vertx.kafka.client.producer.KafkaProducerRecord
import io.vertx.kafka.client.producer.RecordMetadata
import net.cloudopt.next.logging.Logger
import net.cloudopt.next.web.config.ConfigManager
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology


/*
 * @author: Cloudopt
 * @Time: 2018/2/9
 * @Description: Kafka manager of cloudopt next
 */
object KafkaManager {

    val logger = Logger.getLogger(KafkaManager::class.java)

    @JvmStatic
    internal val kafkaList: MutableMap<String, MutableSet<Class<*>>> = hashMapOf()

    @JvmStatic
    var consumer: KafkaConsumer<Any, Any>? = null

    @JvmStatic
    var producer: KafkaProducer<Any, Any>? = null

    @JvmStatic
    var streams: KafkaStreams? = null

    @JvmStatic
    val streamsTopology = Topology()

    @JvmStatic
    var config = ConfigManager.init("kafka") as MutableMap<String, String>


    @JvmOverloads
    fun send(
        topic: String,
        key: String = "",
        value: String = "",
        partition: Int = 0,
        result: Handler<AsyncResult<RecordMetadata>>? = null
    ) {
        var record = KafkaProducerRecord.create<Any, String>(topic, key, value, partition)
        if (result == null) {
            producer?.write(record as KafkaProducerRecord<Any, Any>)
        } else {
            producer?.write(record as KafkaProducerRecord<Any, Any>)
        }
    }

}