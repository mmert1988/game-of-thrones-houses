package com.mehmedmert.gameofthroneshouses.data.repositories

import com.mehmedmert.gameofthroneshouses.network.model.HouseApiModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class HouseMapperTest {
    @Test
    fun `maps HouseApiModel correctly to House`() {
        // given
        val houseApiModel = HouseApiModel(
            url = "https://anapioficeandfire.com/api/houses/378",
            name = "House Targaryen of King's Landing",
            region = "The Crownlands",
            coatOfArms = "Sable, a dragon thrice-headed gules",
            words = "Fire and Blood",
            titles = listOf(
                "King of the Andals, the Rhoynar and the First Men",
                "Lord of the Seven Kingdoms",
                "Prince of Summerhall",
            ),
            seats = listOf(
                "Red Keep (formerly)",
                "Summerhall (formerly)",
            ),
            currentLord = "https://anapioficeandfire.com/api/characters/1303",
            heir = "",
            overlord = "",
            founded = "House Targaryen: >114 BCHouse Targaryen of King's Landing:1 AC",
            founder = "",
            diedOut = "",
            ancestralWeapons = listOf(
                "Blackfyre",
                "Dark Sister",
            ),
            cadetBranches = listOf(
                "https://anapioficeandfire.com/api/houses/23",
            ),
            swornMembers = listOf(
                "https://anapioficeandfire.com/api/characters/33",
                "https://anapioficeandfire.com/api/characters/42",
                "https://anapioficeandfire.com/api/characters/43",
                "https://anapioficeandfire.com/api/characters/44",
                "https://anapioficeandfire.com/api/characters/45",
                "https://anapioficeandfire.com/api/characters/48",
                "https://anapioficeandfire.com/api/characters/49",
                "https://anapioficeandfire.com/api/characters/55",
                "https://anapioficeandfire.com/api/characters/58",
                "https://anapioficeandfire.com/api/characters/59",
                "https://anapioficeandfire.com/api/characters/76",
                "https://anapioficeandfire.com/api/characters/91",
                "https://anapioficeandfire.com/api/characters/93",
                "https://anapioficeandfire.com/api/characters/109",
                "https://anapioficeandfire.com/api/characters/110",
                "https://anapioficeandfire.com/api/characters/154",
                "https://anapioficeandfire.com/api/characters/155",
                "https://anapioficeandfire.com/api/characters/156",
                "https://anapioficeandfire.com/api/characters/157",
                "https://anapioficeandfire.com/api/characters/161",
                "https://anapioficeandfire.com/api/characters/168",
                "https://anapioficeandfire.com/api/characters/169",
                "https://anapioficeandfire.com/api/characters/195",
                "https://anapioficeandfire.com/api/characters/239",
                "https://anapioficeandfire.com/api/characters/265",
                "https://anapioficeandfire.com/api/characters/266",
                "https://anapioficeandfire.com/api/characters/269",
                "https://anapioficeandfire.com/api/characters/270",
                "https://anapioficeandfire.com/api/characters/271",
                "https://anapioficeandfire.com/api/characters/272",
                "https://anapioficeandfire.com/api/characters/275",
                "https://anapioficeandfire.com/api/characters/276",
                "https://anapioficeandfire.com/api/characters/330",
                "https://anapioficeandfire.com/api/characters/334",
                "https://anapioficeandfire.com/api/characters/361",
                "https://anapioficeandfire.com/api/characters/488",
                "https://anapioficeandfire.com/api/characters/546",
                "https://anapioficeandfire.com/api/characters/560",
                "https://anapioficeandfire.com/api/characters/576",
                "https://anapioficeandfire.com/api/characters/610",
                "https://anapioficeandfire.com/api/characters/611",
                "https://anapioficeandfire.com/api/characters/696",
                "https://anapioficeandfire.com/api/characters/709",
                "https://anapioficeandfire.com/api/characters/729",
                "https://anapioficeandfire.com/api/characters/759",
                "https://anapioficeandfire.com/api/characters/767",
                "https://anapioficeandfire.com/api/characters/779",
                "https://anapioficeandfire.com/api/characters/797",
                "https://anapioficeandfire.com/api/characters/865",
                "https://anapioficeandfire.com/api/characters/867",
                "https://anapioficeandfire.com/api/characters/868",
                "https://anapioficeandfire.com/api/characters/869",
                "https://anapioficeandfire.com/api/characters/870",
                "https://anapioficeandfire.com/api/characters/871",
                "https://anapioficeandfire.com/api/characters/872",
                "https://anapioficeandfire.com/api/characters/873",
                "https://anapioficeandfire.com/api/characters/874",
                "https://anapioficeandfire.com/api/characters/875",
                "https://anapioficeandfire.com/api/characters/876",
                "https://anapioficeandfire.com/api/characters/951",
                "https://anapioficeandfire.com/api/characters/971",
                "https://anapioficeandfire.com/api/characters/1067",
                "https://anapioficeandfire.com/api/characters/1070",
                "https://anapioficeandfire.com/api/characters/1079",
                "https://anapioficeandfire.com/api/characters/1114",
                "https://anapioficeandfire.com/api/characters/1142",
                "https://anapioficeandfire.com/api/characters/1205",
                "https://anapioficeandfire.com/api/characters/1242",
                "https://anapioficeandfire.com/api/characters/1302",
                "https://anapioficeandfire.com/api/characters/1303",
                "https://anapioficeandfire.com/api/characters/1340",
                "https://anapioficeandfire.com/api/characters/1358",
                "https://anapioficeandfire.com/api/characters/1445",
                "https://anapioficeandfire.com/api/characters/1450",
                "https://anapioficeandfire.com/api/characters/1469",
                "https://anapioficeandfire.com/api/characters/1520",
                "https://anapioficeandfire.com/api/characters/1523",
                "https://anapioficeandfire.com/api/characters/1527",
                "https://anapioficeandfire.com/api/characters/1528",
                "https://anapioficeandfire.com/api/characters/1548",
                "https://anapioficeandfire.com/api/characters/1549",
                "https://anapioficeandfire.com/api/characters/1560",
                "https://anapioficeandfire.com/api/characters/1589",
                "https://anapioficeandfire.com/api/characters/1608",
                "https://anapioficeandfire.com/api/characters/1709",
                "https://anapioficeandfire.com/api/characters/1739",
                "https://anapioficeandfire.com/api/characters/1826",
                "https://anapioficeandfire.com/api/characters/1856",
                "https://anapioficeandfire.com/api/characters/1867",
                "https://anapioficeandfire.com/api/characters/1872",
                "https://anapioficeandfire.com/api/characters/1873",
                "https://anapioficeandfire.com/api/characters/1874",
                "https://anapioficeandfire.com/api/characters/1897",
                "https://anapioficeandfire.com/api/characters/1944",
                "https://anapioficeandfire.com/api/characters/1948",
                "https://anapioficeandfire.com/api/characters/1978",
                "https://anapioficeandfire.com/api/characters/1981",
                "https://anapioficeandfire.com/api/characters/2071",
                "https://anapioficeandfire.com/api/characters/2086",
                "https://anapioficeandfire.com/api/characters/2124",
                "https://anapioficeandfire.com/api/characters/2128",
            )
        )

        // when
        val house = HouseMapper.map(houseApiModel)

        // then
        assertEquals("https://anapioficeandfire.com/api/houses/378", house.url)
        assertEquals("House Targaryen of King's Landing", house.name)
        assertEquals("The Crownlands", house.region)
        assertEquals("Fire and Blood", house.words)
    }
}