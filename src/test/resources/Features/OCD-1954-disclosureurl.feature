Feature: This is to test updated mandatory disclosure urls for cerner listings

  Scenario Outline: Verify mandatory disclosure link update for Cerner listings
    Given I am on listing details page of listing with CHPL ID "<CHPL_ID>"
    Then the Mandatory Disclosures URL should be: "<URL>"
    Examples:
      | CHPL_ID                           | URL                                                 |
      | 14.07.07.1221.FIA1.10.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA1.11.01.1.170321 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA1.12.01.1.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA1.13.01.1.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA1.14.01.1.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA1.15.01.1.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA1.16.01.1.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA1.17.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA1.18.01.1.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA1.19.01.1.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA1.20.01.1.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA2.10.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA2.11.01.1.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA2.12.01.1.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA2.13.01.1.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA2.14.01.1.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA2.15.01.1.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA2.16.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA2.17.01.1.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA2.18.01.1.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA2.19.01.1.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA4.09.01.0.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA4.10.01.0.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA4.11.01.0.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA4.12.01.0.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA4.13.01.0.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA4.14.01.0.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA4.15.01.0.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA4.16.01.0.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA4.17.01.0.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FIA4.18.01.0.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII1.10.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII1.11.01.1.170321 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII1.12.01.1.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII1.13.01.1.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII1.14.01.1.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII1.15.01.1.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII1.16.01.1.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII1.17.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII1.18.01.1.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII1.19.01.1.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII1.20.01.1.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII3.09.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII3.10.01.1.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII3.11.01.1.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII3.12.01.1.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII3.13.01.1.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII3.14.01.1.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII3.15.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII3.16.01.1.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII3.17.01.1.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII3.18.01.1.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII4.09.01.0.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII4.10.01.0.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII4.11.01.0.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII4.12.01.0.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII4.13.01.0.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII4.14.01.0.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII4.15.01.0.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII4.16.01.0.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII4.17.01.0.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.FII4.18.01.0.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA2.15.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA2.16.01.1.170321 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA2.17.01.1.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA2.18.01.1.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA2.19.01.1.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA2.20.01.1.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA2.21.01.1.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA2.22.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA2.23.01.1.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA2.24.01.1.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA2.25.01.1.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA3.10.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA3.11.01.1.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA3.12.01.1.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA3.13.01.1.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA3.14.01.1.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA3.15.01.1.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA3.16.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA3.17.01.1.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA3.18.01.1.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEA3.19.01.1.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI2.15.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI2.16.01.1.170321 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI2.17.01.1.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI2.18.01.1.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI2.19.01.1.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI2.20.01.1.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI2.21.01.1.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI2.22.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI2.23.01.1.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI2.24.01.1.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI2.25.01.1.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI3.10.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI3.11.01.1.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI3.12.01.1.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI3.13.01.1.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI3.14.01.1.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI3.15.01.1.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI3.16.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI3.17.01.1.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI3.18.01.1.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.HEI3.19.01.1.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.PAA3.09.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.PAA3.10.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.PAI3.09.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.PAI3.10.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA1.15.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA1.16.01.1.170321 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA1.17.01.1.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA1.18.01.1.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA1.19.01.1.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA1.20.01.1.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA1.21.01.1.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA1.22.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA1.23.01.1.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA1.24.01.1.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA1.25.01.1.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA4.09.01.0.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA4.10.01.0.170321 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA4.11.01.0.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA4.12.01.0.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA4.13.01.0.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA4.14.01.0.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA4.15.01.0.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA4.16.01.0.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA4.17.01.0.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA4.18.01.0.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA4.19.01.0.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA5.15.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA5.16.01.1.170321 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA5.17.01.1.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA5.18.01.1.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA5.19.01.1.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA5.20.01.1.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA5.21.01.1.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA5.22.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA5.23.01.1.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA5.24.01.1.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POA5.25.01.1.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI2.15.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI2.16.01.1.170321 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI2.17.01.1.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI2.18.01.1.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI2.19.01.1.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI2.20.01.1.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI2.21.01.1.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI2.22.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI2.23.01.1.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI2.24.01.1.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI2.25.01.1.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI3.15.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI3.16.01.1.170321 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI3.17.01.1.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI3.18.01.1.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI3.19.01.1.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI3.20.01.1.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI3.21.01.1.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI3.22.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI3.23.01.1.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI3.24.01.1.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI3.25.01.1.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI4.09.01.0.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI4.10.01.0.170321 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI4.11.01.0.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI4.12.01.0.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI4.13.01.0.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI4.14.01.0.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI4.15.01.0.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI4.16.01.0.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI4.17.01.0.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI4.18.01.0.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI4.19.01.0.170728 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI5.15.01.1.170320 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI5.16.01.1.170321 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI5.17.01.1.170327 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI5.18.01.1.170426 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI5.19.01.1.170510 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI5.20.01.1.170519 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI5.21.01.1.170608 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI5.22.01.1.170705 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI5.23.01.1.170711 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI5.24.01.1.170727 | https://www.cerner.com/cehrt-disclosure-information |
      | 14.07.07.1221.POI5.25.01.1.170728 | https://www.cerner.com/cehrt-disclosure-information |