package org.student.service.impl;
                                                                //第五步，业务逻辑层， 逻辑性的增删改查
import org.student.dao.IStudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
   IStudentDao studentDao = new StudentDaoImpl();

   //逻辑增加学生（查+增）
    public boolean addStudent(Student student){

        if(!studentDao.isExist(student.getSno())){//不存在
            if(studentDao.addStudent(student)){
                return true;
            }
            return false;
        }else {
            System.out.println("此人已存在");
            return false;
        }
    }

    //删除学生
    public boolean deleteStudentBySno(int sno){
        if(studentDao.isExist(sno)){
            return studentDao.deleteStudentBySno(sno);

        }
        return false;
    }

    //修改学生信息
    public boolean updateStudentBySno(int sno, Student student){
        if(studentDao.isExist(sno)){
            return studentDao.updateStudentBySno(sno, student);
        }
        return false;
    }

    //根据学号查询学生
    public Student queryStudentBySno(int sno){
        return studentDao.queryStudentBySno(sno);
    }

    //查询全部学生
    public List<Student> queryAllStudents(){
        return studentDao.queryAllStudents();
    }


}
