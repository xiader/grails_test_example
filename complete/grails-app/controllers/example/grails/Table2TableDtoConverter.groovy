package example.grails

import example.grails.dto.TableDTO

class Table2TableDtoConverter {

    static TableDTO convert(Table table) {
        if (table == null) {
            return null
        }
        TableDTO tableDTO = new TableDTO()
        tableDTO.setId(table.getId())
        tableDTO.setName(table.getName())
        tableDTO.setParticipants(table.getParticipants())

        return tableDTO
    }
}
