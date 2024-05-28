package io.rjnsh.summer.zero.ioc;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class WithIOC {
    private final IOCSlugService iocSlugService;
    private static final Logger LOG = LogManager.getLogger(WithIOC.class);

    public WithIOC(IOCSlugService iocSlugService) {
        this.iocSlugService = iocSlugService;
    }
}

interface IOCSlugService {
    void slugify(String title);
}

@Component
class IOCSlugServiceImpl implements IOCSlugService {
    private static final Logger LOG = LogManager.getLogger(IOCSlugServiceImpl.class);
    @Override
    public void slugify(String title) {
        LOG.info("received {}", title);
    }

}