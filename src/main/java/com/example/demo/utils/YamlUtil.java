package com.example.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author Elijah
 * @create 2020-05-29 11:31
 */
@Slf4j
public class YamlUtil {
    public static Map getMap(String filename) {
        InputStream in = null;
        Map map = null;
        try {
            Yaml yaml = new Yaml();
            // 配置文件地址
            in = YamlUtil.class.getResourceAsStream(filename);
            map = yaml.loadAs(in, Map.class);
            log.info("map:" + map);
        } catch (Exception e) {
            log.error("读取配置文件出错:", e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return map;
    }
}
