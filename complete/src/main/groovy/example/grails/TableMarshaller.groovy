package example.grails

import grails.converters.JSON

class TableMarshaller {

    void register() {
        JSON.registerObjectMarshaller(Table) { Table table ->
            return [
                    id          : table.id,
                    name        : table.name,
                    participants: table.participants,
                    _entityType : 'Table'
            ]
        }
    }
}
