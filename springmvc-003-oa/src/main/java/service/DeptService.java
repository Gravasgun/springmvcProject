package service;

import bean.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 展示部门列表页面
     *
     * @return
     */
    public List<Dept> display();

    /**
     * 删除
     *
     * @param deptno
     * @return
     */

    public int delete(Integer deptno);

    /**
     * 新增
     *
     * @param dept
     * @return
     */
    public int insert(Dept dept);

    /**
     * 查一个
     *
     * @param deptno
     * @return
     */

    public Dept selectOne(Integer deptno);

    /**
     * 修改
     *
     * @param dept
     * @return
     */

    public int update(Dept dept);
}
