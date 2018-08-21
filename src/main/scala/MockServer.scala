import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock._

import com.github.tomakehurst.wiremock.core.WireMockConfiguration.options

object MockServer extends App {
  override def main(args: Array[String]): Unit = {
    val server = new WireMockServer(options().usingFilesUnderDirectory("src/main/resources"))
    server.start
    configureFor("localhost", 8080)

    stubFor(get(urlEqualTo("/test"))
      .willReturn(aResponse()
        .withBodyFile("positions.json")))

    stubFor(get(urlPathMatching("/positions"))
      .withQueryParam("groupBy", matching("assets"))
      .withHeader("x-member-id", matching("23232"))
      .willReturn(aResponse()
        .withBodyFile("positions_group_by_assets.json")))
  }
}