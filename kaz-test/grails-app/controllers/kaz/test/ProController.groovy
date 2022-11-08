package kaz.test

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProController {

    ProService proService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond proService.list(params), model:[proCount: proService.count()]
    }

    def show(Long id) {
        respond proService.get(id)
    }

    def create() {
        respond new Pro(params)
    }

    def save(Pro pro) {
        if (pro == null) {
            notFound()
            return
        }

        try {
            proService.save(pro)
        } catch (ValidationException e) {
            respond pro.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pro.label', default: 'Pro'), pro.id])
                redirect pro
            }
            '*' { respond pro, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond proService.get(id)
    }

    def update(Pro pro) {
        if (pro == null) {
            notFound()
            return
        }

        try {
            proService.save(pro)
        } catch (ValidationException e) {
            respond pro.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pro.label', default: 'Pro'), pro.id])
                redirect pro
            }
            '*'{ respond pro, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        proService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pro.label', default: 'Pro'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pro.label', default: 'Pro'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
