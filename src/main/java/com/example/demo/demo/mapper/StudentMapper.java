package com.example.demo.demo.mapper;

import com.example.demo.demo.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生表 Mapper
 *
 * @author Elijah
 * @since 2020-05-28
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
