import geb.spock.GebReportingSpec

class LocalStorageSpec extends GebReportingSpec {

    def "set item"() {
      given:
      go ""

      when:
      js.exec "window.localStorage.setItem('dummy', 'dummy');"

      then:
      js. "window.localStorage.getItem('dummy')" == "dummy"

      when:
      js.exec "window.localStorage.removeItem('dummy')"

      then:
      js. "window.localStorage.getItem('dummy')" == null

      when:
      js.exec "window.localStorage.setItem('dummy', 'dummy');"

      and:
      js.exec "window.localStorage.clear()"

      then:
      js. "window.localStorage.getItem('dummy')" == null
    }
}
