package com.nst.dms.base;

import com.nst.dms.service.DescriptorService;
import com.nst.dms.service.DocumentTypeService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by nmarkovi on 3/4/18.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class BaseServiceTest {

    @Autowired
    protected DescriptorService descriptorService;

    @Autowired
    protected DocumentTypeService documentTypeService;

}
