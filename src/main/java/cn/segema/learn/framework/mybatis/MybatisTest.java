package cn.segema.learn.framework.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MybatisTest {

	StudentDao dao;

	SqlSession sqlSession;

	@Before
	public void before() {
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(StudentDao.class);
	}

	@After
	public void after() {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}

	@Test
	public void test01() {
		Student student = new Student("张三", 23, 93);
		dao.insertStudent(student);
		sqlSession.commit();
	}

	@Test
	public void test02() {
		Student student = new Student("张三", 23, 93);
		System.out.println("插入前：" + student);
		dao.insertStudentCacheId(student);
		sqlSession.commit();
		System.out.println("插入后：" + student);
	}

	@Test
	public void test03() {
		dao.deleteStudentById(13);
		sqlSession.commit();
	}

	@Test
	public void test04() {
		Student student = new Student("王五", 25, 95);
		student.setId(19);
		dao.updateStudentById(student);
		sqlSession.commit();
	}

	@Test
	public void test05() {
		List<Student> students = dao.selectAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void test06() {
		Map<String, Object> map = dao.selectAllStudentsMap();
		System.out.println(map.get("张三"));
	}

	@Test
	public void test07() {
		Student student = dao.selectById(7);
		System.out.println(student);
	}

	@Test
	public void test08() {
		List<Student> students = dao.selectByName("张");
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
