package kaz.test

import grails.gorm.services.Service

@Service(Pro)
interface ProService {

    Pro get(Serializable id)

    List<Pro> list(Map args)

    Long count()

    void delete(Serializable id)

    Pro save(Pro pro)

}