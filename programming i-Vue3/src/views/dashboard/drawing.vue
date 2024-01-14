<template>
  <div>
    <div id="top-left" style="height:700px"></div>
  </div>
</template>

<script>
import * as echarts from "echarts";
import {getCounts} from '@/api/drawing'
export default {
  name: 'count',
  data(){
    return {
      option :{
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '5%',
          left: 'center'
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: '40',
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            data: [
              { value: 1048, name: '日常消耗' },
              { value: 735, name: '工资发放' },
              { value: 580, name: '盈利' },
            ]
          }
        ]
      }
    }
  },
  mounted() {
    getCounts().then(data =>{
      console.log(data)
      this.option.series[0].data[0].value = data.consumes
      this.option.series[0].data[1].value = data.moneyGrant
      this.option.series[0].data[2].value = data.gains

      this.topleft()
      // console.log(this.params)
    })
  },
  methods:{
    topleft() {
      let myChart = echarts.init(document.getElementById("top-left"));
      this.option && myChart.setOption(this.option);
    },
  }
}
</script>

<style scoped>

</style>
