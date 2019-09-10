package cn.wbc.dao.impl;

import cn.wbc.dao.IAccountDao;
import cn.wbc.dao.IAccountDao;
import cn.wbc.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao{
    private QueryRunner runner;
    //这里的QueryRunner 也是可以使用Spring实现注入
    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        /*
            在第一个的基础上，因为有了参数就增加一个 accountId 的参数
            并且，方法的返回值类型不再是List类型了，我们就用BeanHandler完事
         */
        try {
            return runner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        /*
            再第二个方法的基础上发生了如下变化：
                1.参数发生改变，所以还是要有参数的  ========>  通过getname，和getmoney获得了所需要的参数，因为id设置主键自增所以不需要get
                2.方法的返回值类型发生变化，是void  ========>  没有返回值
                3.方法的使用方式发生变化，不再是查询操作，而是增加  ========>  增删操作的runner调用的方法就是update了，insert into
         */
        try {
            runner.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            runner.update("delete from account where id=?",accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

