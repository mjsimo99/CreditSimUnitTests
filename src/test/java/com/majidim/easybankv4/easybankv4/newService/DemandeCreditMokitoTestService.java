package com.majidim.easybankv4.easybankv4.newService;

import com.majidim.easybankv4.easybankv4.HibernateImps.DemandeCreditImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;


public class DemandeCreditMokitoTestService {
    @InjectMocks
    private DemandeCreditService demandeCreditService;

    @Mock
    private DemandeCreditImpl demandeCreditImpl;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

}
