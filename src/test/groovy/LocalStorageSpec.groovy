import geb.spock.GebReportingSpec

class LocalStorageSpec extends GebReportingSpec {

    def "set item"() {
      given:
      go ""

      when:
      js.exec "window.localStorage.setItem('dummy', 'dummy');"

      then:
      js. "window.localStorage.getItem('dummy')" == ""
    }
}
