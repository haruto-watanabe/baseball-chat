package com.example.demo;

/**
 * 試合情報を保持するRecord。
 * フィールドは自動的にprivate finalになり、getterも自動生成されます。
 */
public record BaseballGame(
        String id,        // dena-vs-chunichi-20260502
        String date,      // 2026-05-02
        String startTime, // 14:00
        String homeTeam,  // 中日
        String awayTeam,  // 横浜DeNA
        String venue,     // バンテリンドーム
        String status     // LIVE, FINISHED, 14:00開始 など
) {}