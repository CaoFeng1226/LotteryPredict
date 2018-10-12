::cd C:\Developing\Klocwork\Server 18.2\bin%


kwbuildproject --url http://localhost:8090/LotteryPredict --tables-directory "C:\Develop_file\Klockwork\my_tables\LotteryPredict" --force LotteryPredict.out 


kwadmin --url http://localhost:8090/ load LotteryPredict "C:\Develop_file\Klockwork\my_tables\LotteryPredict"