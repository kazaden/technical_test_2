package kaz.test

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProServiceSpec extends Specification {

    ProService proService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pro(...).save(flush: true, failOnError: true)
        //new Pro(...).save(flush: true, failOnError: true)
        //Pro pro = new Pro(...).save(flush: true, failOnError: true)
        //new Pro(...).save(flush: true, failOnError: true)
        //new Pro(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pro.id
    }

    void "test get"() {
        setupData()

        expect:
        proService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pro> proList = proService.list(max: 2, offset: 2)

        then:
        proList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        proService.count() == 5
    }

    void "test delete"() {
        Long proId = setupData()

        expect:
        proService.count() == 5

        when:
        proService.delete(proId)
        sessionFactory.currentSession.flush()

        then:
        proService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pro pro = new Pro()
        proService.save(pro)

        then:
        pro.id != null
    }
}
