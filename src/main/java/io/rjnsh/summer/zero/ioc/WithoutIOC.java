package io.rjnsh.summer.zero.ioc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WithoutIOC {
    // without IOC, we need to 
    private final SlugService slugService = new SlugServiceImpl();
    private static final Logger LOG = LogManager.getLogger(WithoutIOC.class);
    public static void main(String[] args) {
        WithoutIOC ioc = new WithoutIOC();
        ioc.run();
    }

    public void run() {
        slugService.slugify("My life without DI :(");
    }
}

interface SlugService {
    void slugify(String title);
}

class SlugServiceImpl implements SlugService {
    private static final Logger LOG = LogManager.getLogger(SlugServiceImpl.class);

    @Override
    public void slugify(String title) {
        LOG.info("title slug {}", title);
    }
}