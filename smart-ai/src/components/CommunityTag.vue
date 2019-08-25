<template>
    <div class="fs14">
        <div>
            <div class="chart-title">社区住户出行规律</div>
            <div class="chart-container" id='tripChart'></div>
        </div>
        <div>
            <div class="chart-title mt16">社区住户能源消费</div>
            <div class="chart-container" id='resourceChart'></div>
        </div>
        <!-- <div class="oper-box"> -->

        <div class="mt16">
            <el-input
                class="name-input"
                placeholder="请输入姓名"
                v-model="stateHome.community.name"
                clearable>
            </el-input>
            <el-button type="primary" @click="appraise">评估</el-button>
        </div>
        <div class="fs14">
            <el-row :span='24' class="item-row">
                <el-col :span='4'>该用户困难指数:</el-col>
                <el-col :span='2'>{{stateHome.community.diffculty}}</el-col>
                <el-col :span='10'>
                    <el-button type="mini" plain>社区帮助</el-button>
                </el-col>
            </el-row>
            <el-row :span='24' class="item-row">
                <el-col :span='4'>能源消费:</el-col>
                <el-col :span='2'>{{stateHome.community.energyConsumption}}</el-col>
            </el-row>
            <el-row :span='24' class="item-row">
                <el-col :span='4'>危险指数:</el-col>
                <el-col :span='2' class="fs14">{{stateHome.community.rishLevel}}</el-col>
            </el-row>
        </div>
        <!-- </div> -->

    </div>
</template>
<script>
import { mapState, mapActions } from 'vuex'

export default {
    name: 'CommunityTag',

    computed: mapState({
        stateHome: state => state.home
    }),

    data() {
        return {
            tripChartData: {
                dataAxis: [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24],
                dataYaxis: [220, 182, 191, 234, 290, 290, 290, 290, 290, 290, 290, 290, 290, 290, 290, 290, 290, 290, 290, 290, 290, 290, 290, 290, 290],
            }
        }
    },

    mounted() {
        // this.initTripChart()
        this.$store.dispatch('home/getTripChart')
        this.$store.dispatch('home/getResourceChart')
    },

    watch: {
        'stateHome.tripChart': {
            handler(newName, oldName) {
                this.initTripChart()
            },
            deep: true,
        },
        'stateHome.resourceChart': {
            handler(newName, oldName) {
                this.initTripChart()
            },
            deep: true,
        },
    },

    methods: {
        initTripChart() {
            let tripChart = echarts.init(document.querySelector('#tripChart'));
            let resourceChart = echarts.init(document.querySelector('#resourceChart'));
            tripChart.setOption(this.getOption(this.stateHome.tripChart.dataAxis, this.stateHome.tripChart.dataYaxis, '社区住户出行规律'))
            resourceChart.setOption(this.getOption(this.stateHome.resourceChart.dataAxis, this.stateHome.resourceChart.dataYaxis, '社区住户能源消费'))
        },

        appraise() {
            this.$store.dispatch('home/getCommunity', {name: this.stateHome.community.name})
        },

        getOption(dataAxis, dataYaxis, yName) {
            let option = {
                color: ['#3398DB'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '5%',
                    bottom: '4%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        name: '时间',
                        data : dataAxis,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name: yName,
                        type: 'bar',
                        barWidth: '30%',
                        data: dataYaxis
                    }
                ]
            }
            return option
        },
    },
}
</script>
<style lang="less" scoped>
@borderWidth: 1px solid #eee;

    .chart-title{
        margin-bottom: 16px;
    }

    .chart-container{
        border: @borderWidth;
        // margin-left: 50px;
        width: 900px;
        height: 260px;
    }

    .name-input{
        width: 234px;
        margin-right: 16px;
    }

    .item-row{
        margin-top: 16px;
    }

    .oper-box{
        padding-left: 50px;
    }
</style>