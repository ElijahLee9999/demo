package com.example.demo.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;

/**
 * MyBatis-Plus配置
 * @author Elijah
 * @create 2020-05-28 13:59
 */
@Slf4j
@Configuration
public class MyBatisConfig {
    private final String dateTimeFormatRegx = "yyyy-MM-dd HH:mm:ss.SSS";
    private final String timeZoneString = "GMT";

    /**
     * MyBatis-Plus字段类型处理器
     * @return Jackson2ObjectMapperBuilderCustomizer
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer(){
        /**return builder -> builder.featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);*/
        return (Jackson2ObjectMapperBuilder builder) -> {
            builder.featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);     //处理枚举的序列化
            builder.simpleDateFormat(dateTimeFormatRegx);   // 设置时间格式
            builder.timeZone(timeZoneString);   //设置时区
            builder.serializers(new MyJsonSerializer());    //处理DateTime的序列化
            builder.deserializers(new MyJsonDeserializer());    //处理DateTime的反序列化
        };
    }

    private class MyJsonSerializer extends JsonSerializer<DateTime> {
        @Override
        public void serialize(DateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(dateTime.toString(dateTimeFormatRegx));
        }

        @Override
        public Class<DateTime> handledType() {
            return DateTime.class;
        }
    }

    private class MyJsonDeserializer extends JsonDeserializer<DateTime> {
        @Override
        public DateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            DateTimeFormatter dtf = DateTimeFormat.forPattern(dateTimeFormatRegx);
            return DateTime.parse(jsonParser.toString(), dtf);
        }

        @Override
        public Class<DateTime> handledType() {
            return DateTime.class;
        }
    }
}
