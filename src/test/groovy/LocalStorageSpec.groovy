import geb.spock.GebReportingSpec

class LocalStorageSpec extends GebReportingSpec {

    def "set item"() {
      given:
      go ""

      when:
      js.exec "localStorage.setItem('dummy', 'dummy');"

      then:
      js. "localStorage.getItem('dummy')" == "dummy"

      when:
      js.exec "localStorage.removeItem('dummy')"

      then:
      js. "localStorage.getItem('dummy')" == null

      when:
      js.exec "localStorage.setItem('dummy', 'dummy');"

      and:
      js.exec "localStorage.clear()"

      then:
      js. "localStorage.getItem('dummy')" == null
    }
}
