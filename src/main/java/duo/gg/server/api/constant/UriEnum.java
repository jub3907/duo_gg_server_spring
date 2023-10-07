package duo.gg.server.api.constant;

public enum UriEnum {
    // ACCOUNT
    GET_ACCOUNT_BY_PUUID,           // /riot/account/v1/accounts/by-puuid/{puuid}
    GET_ACCOUNT_BY_RIOT_ID,         // /riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}
    GET_ACCOUNT_BY_ACCESS_TOKEN,    // /riot/account/v1/accounts/me
    GET_ACTIVE_SHARD,               // /riot/account/v1/active-shards/by-game/{game}/by-puuid/{puuid}

    // CHAMPION-MASTERY
    GET_CHAMPION_MASTERIES_BY_PUUID,                        // /lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}
    GET_CHAMPION_MASTERY_BY_PUUID_AND_CHAMPION_ID,          // /lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}/by-champion/{championId}
    GET_CHAMPION_MASTERIES_BY_PUUID_DESCENDING,             // /lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}/top

    GET_CHAMPION_MASTERIES_BY_SUMMONER_ID,                  // /lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}
    GET_CHAMPION_MASTERY_BY_SUMMONER_ID_AND_CHAMPION_ID,    // /lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}/by-champion/{championId}
    GET_CHAMPION_MASTERIES_BY_SUMMONER_ID_DESCENDING,       // /lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}/top

    GET_CHAMPION_MASTERY_SCORES_BY_PUUID,                   // /lol/champion-mastery/v4/scores/by-puuid/{encryptedPUUID}
    GET_CHAMPION_MASTERY_SCORES_BY_SUMMONER_ID,             // /lol/champion-mastery/v4/scores/by-summoner/{encryptedSummonerId}

    // CHAMPION
    GET_CHAMPION_ROTATION,                                  // /lol/platform/v3/champion-rotations

    // LEAGUE-EXP
    GET_LEAGUE_ENTRIES_EXP,                                 // /lol/league-exp/v4/entries/{queue}/{tier}/{division}

    // LEAGUE
    GET_LEAGUES_BY_LEAGUE_ID,                               // /lol/league/v4/leagues/{leagueId}
    GET_LEAGUE_ENTRIES_BY_SUMMONER_ID,                      // /lol/league/v4/entries/by-summoner/{encryptedSummonerId}
    GET_LEAGUE_ENTRIES,                                     // /lol/league/v4/entries/{queue}/{tier}/{division}
    GET_CHALLENGER_LEAGUES_BY_QUEUE,                        // /lol/league/v4/challengerleagues/by-queue/{queue}
    GET_GRANDMASTER_LEAGUES_BY_QUEUE,                       // /lol/league/v4/grandmasterleagues/by-queue/{queue}
    GET_MASTER_LEAGUES_BY_QUEUE,                            // /lol/league/v4/masterleagues/by-queue/{queue}

    // MATCH
    GET_MATCH_IDS_BY_PUUID,                                 // /lol/match/v5/matches/by-puuid/{puuid}/ids
    GET_MATCH_BY_MATCH_ID,                                  // /lol/match/v5/matches/{matchId}
    GET_MATCH_TIMELINE_BY_MATCH_ID,                         // /lol/match/v5/matches/{matchId}/timeline

    // SUMMONER
    GET_SUMMONER_BY_RSO_PUUID,                              // /fulfillment/v1/summoners/by-puuid/{rsoPUUID}
    GET_SUMMONER_BY_ACCOUNT_ID,                             // /lol/summoner/v4/summoners/by-account/{encryptedAccountId}
    GET_SUMMONER_BY_SUMMONER_NAME,                          // /lol/summoner/v4/summoners/by-name/{summonerName}
    GET_SUMMONER_BY_PUUID,                                  // /lol/summoner/v4/summoners/by-puuid/{encryptedPUUID}
    GET_SUMMONER_BY_ACCESS_TOKEN,                           // /lol/summoner/v4/summoners/me
    GET_SUMMONER_BY_SUMMONER_ID,                            // /lol/summoner/v4/summoners/{encryptedSummonerId}

}
