package example.grails

import example.grails.dto.ResponseDTO
import example.grails.dto.TableDTO
import org.grails.web.json.JSONObject

class JsonManagerService {

    TableService tableService


    def parseJson(JSONObject o) {
        switch (o.$type) {
            case ("ping"):
                return "{\"\$type\":\"pong\", \"seq\": ${o.seq}}"
                break
            case (o.table_list):
                return tableService.findAll()
            case ("add_table"):
                Table detached = o.table as Table
                Table saved = tableService.save(detached)
                Table2TableDtoConverter
                ResponseDTO responseDTO = new ResponseDTO()

                TableDTO tableDTO = new TableDTO()
                tableDTO.setName(saved.getName())
                tableDTO.setParticipants(saved.getParticipants())
                tableDTO.setId(saved.getId())

                responseDTO.setTable(tableDTO)
                responseDTO.setAfter_id(null)
                responseDTO.set$type("add_table")
                return responseDTO
            case ("update_table"):
                Table detached = o.table as Table
                Long id = (o.table as Table).getId()
                Table persisted = tableService.get(id)
                persisted.setName(detached.getName())
                persisted.setParticipants(detached.setParticipants())
                break
            case ("remove_table"):
                break
            default:
                return '{"result":"unknown command"}'
        }
    }

    Object getAllAdapt() {
        ResponseDTO responseDTO = new ResponseDTO()
        List<Table> list = tableService.listOrderByIdDesc()
        responseDTO.set$type("table_list")
        List<TableDTO> tableDTOList = new ArrayList<>()
        list.each {tableDTOList.add(Table2TableDtoConverter.convert(it))}
        responseDTO.setTables(tableDTOList)
        return responseDTO
    }
}
