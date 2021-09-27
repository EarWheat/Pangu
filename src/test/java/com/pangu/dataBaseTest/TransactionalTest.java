package com.pangu.dataBaseTest;

import com.pangu.Base.Context.SpringApplicationContext;
import com.pangu.dao.PanguUserMapper;
import com.pangu.po.PanguUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.swing.*;
import java.math.BigDecimal;
import java.util.concurrent.TimeoutException;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/27 11:57 上午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalTest {

    @Resource
    PanguUserMapper panguUserMapper;

//    @Transactional
    @Test
    public void transactionTest() throws Exception {
        System.out.println("扣刘兆禄的钱~");
        deleteCount("liuzhaolu");
        System.out.println("给乐乐转账");
        addCount("guoyuanjiao");
    }

    private void deleteCount(String userId) throws Exception{
        PanguUser user = panguUserMapper.selectByPrimaryKey(userId);
        BigDecimal account = user.getAccount();
        account = account.subtract(new BigDecimal(100));
        user.setAccount(account);
        panguUserMapper.updateByPrimaryKey(user);
        throw new Exception();
    }

    private void addCount(String userId) throws Exception{
        PanguUser user = panguUserMapper.selectByPrimaryKey(userId);
        BigDecimal account = user.getAccount();
        account = account.add(new BigDecimal(100));
        user.setAccount(account);
        panguUserMapper.updateByPrimaryKey(user);
    }
}
