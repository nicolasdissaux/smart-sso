<?php
$config = [
    'sets' => [
        'legrand' => [
            'cron'       => ['hourly'],
            'sources'    => [
                [
                    'src' => 'https://dev-fs-one.grpleg.com/FederationMetadata/2007-06/FederationMetadata.xml',
                ],
            ],
            'expireAfter'  => 60*60*24*4, // Maximum 4 days cache time.
            'outputDir'    => 'metadata',
            'outputFormat' => 'flatfile',
        ],
],
];
