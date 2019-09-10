package cn.wbc.service.impl;

import cn.wbc.dao.IAccountDao;
import cn.wbc.domain.Account;
import cn.wbc.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;


@Service("accountService")
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {
    //业务层去调用持久层，所以我们在这定义一个accountDao
    private IAccountDao accountDao;
    //由于我们的spring注入是依靠我们的set方法所以先创建出来
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
