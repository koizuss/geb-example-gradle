import geb.spock.GebReportingSpec

class LocalStorageSpec extends GebReportingSpec {
    def setup() {
      go ""
    }

    def "set item"() {
      when:
      js.exec "localStorage.setItem('dummy', 'dummy');"

      then:
      js. "localStorage.getItem('dummy')" == "dummy"
    }

    def "remove item"() {
      when:
      js.exec "localStorage.setItem('dummy', 'dummy');"

      and:
      js.exec "localStorage.removeItem('dummy')"

      then:
      js. "localStorage.getItem('dummy')" == null
    }

    def "clear item"() {
      when:
      js.exec "localStorage.setItem('dummy', 'dummy');"

      and:
      js.exec "localStorage.clear()"

      then:
      js. "localStorage.getItem('dummy')" == null
    }

}
