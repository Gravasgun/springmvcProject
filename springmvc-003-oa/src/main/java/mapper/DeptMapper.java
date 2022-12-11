package mapper;

import bean.Dept;

import java.util.List;

public interface DeptMapper {
    /**
     * 新增部门
     *
     * @param dept
     * @return
     */
    int insert(Dept dept);

    /**
     * 删除部门
     *
     * @param deptno
     * @return
     */
    int delete(Integer deptno);

    /**
     * 修改部门信息
     *
     * @param dept
     * @return
     */
    int update(Dept dept);

    /**
     * 查询所有部门的详细信息
     *
     * @return
     */
    List selectAll();

    /**
     * 根据部门编号查询部门信息
     *
     * @param deptno
     * @return
     */
    Dept selectByDeptno(Integer deptno);
}
