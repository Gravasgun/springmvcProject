package service.ipml;

import bean.Dept;
import mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.DeptService;

import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> display() {
        List deptList = deptMapper.selectAll();
        return deptList;
    }

    @Override
    public int delete(Integer deptno) {
        int count = deptMapper.delete(deptno);
        return count;
    }

    @Override
    public int insert(Dept dept) {
        int count = deptMapper.insert(dept);
        return count;
    }

    @Override
    public Dept selectOne(Integer deptno) {
        Dept dept = deptMapper.selectByDeptno(deptno);
        return dept;
    }

    @Override
    public int update(Dept dept) {
        int count = deptMapper.update(dept);
        return count;
    }
}
