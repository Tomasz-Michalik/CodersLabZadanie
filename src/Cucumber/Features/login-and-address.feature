Feature: Dodawanie adresu do zalogowanego użytkownika
  Scenario Outline:Logowanie do konta i dodawanie adresu
    Given Otwórz przeglądarkę na stronie logowania
    And Wpisuję email i hasło
    And Klikam Sign in
    And Klika w zakładke ADDRESSES
    And Klika w + Create new address
    When Wypełnia <alias>, <address>, <city>, <zipcode>, <phone>
    And Klika w przycisk Save
    Then Sprawdzi podany adres
    And Usuń powyższy adress klikając delete
    And Sprawdź czy powyższy adres został usunięty
    And Zamknie przeglądarkę
    Examples: dane adresu
      | alias   | address | city   | zipcode | phone     |
      | example | Zielona | Kraków | 00-001  | 100200300 |