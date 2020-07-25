package example.grails

import grails.gorm.services.Service

//@Service(Table)
class TableService {

    Table get(Serializable id) {
        return Table.get(id)
    }

    List<Table> list(Map args) {
        return Table.findAll(args)
    }

    List<Table> listOrderByIdDesc() {
      return Table.listOrderById(order: "desc")
    }

    Long count() {
        return Table.count
    }

    void delete(Serializable id) {
        def book = Table.get(id)
        book.delete(flush: true)
    }

    Table save(Table table) {
        return table.save()
    }

}